package com.macgregor.ef.resource;

import com.macgregor.ef.exceptions.PageinationException;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractResource {
    public static final String TOTAL_COUNT_HEADER = "X-total-count";
    public static final String LINK_HEADER = "Link";
    public static final int MAX_PAGE_SIZE = 100;

    protected void sanityCheckPagenationParameters(int page, int size, int total) throws PageinationException {
        List<String> errors = new ArrayList<>();

        if(size > MAX_PAGE_SIZE){
            errors.add(String.format("Page size must be less than %d", MAX_PAGE_SIZE));
            size = 10;
        }

        if(page < 1 || page > maxPage(size, total)){
            errors.add(String.format("Page but be within 1 and %d (upper bound changes based on the total number of entities and page size you are querying)", maxPage(size, total)));
        }



        if(errors.size() > 0){
            throw new PageinationException(String.format("%s:\n %s", "Pagination parameters out of bounds", errors.toString()));
        }
    }

    protected List<Link> getPagenationLinks(String uri, int page, int size, int total){
        List<Link> links = new ArrayList<>(5);
        Link self = Link.fromUri("{baseUri}?page={page}&size={size}")
                .rel("self")
                .type("text/plain")
                .baseUri("/")
                .build(uri, page, size);
        links.add(self);

        if(page > 1) {
            Link prev = Link.fromUri("{baseUri}?page={page}&size={size}")
                    .rel("prev")
                    .type("text/plain")
                    .baseUri("/")
                    .build(uri, page-1, size);
            links.add(prev);
        }

        if(page*size < total) {
            Link next = Link.fromUri("{baseUri}?page={page}&size={size}")
                    .rel("next")
                    .type("text/plain")
                    .baseUri("/")
                    .build(uri, page+1, size);
            links.add(next);
        }

        Link first = Link.fromUri("{baseUri}?page={page}&size={size}")
                .rel("first")
                .type("text/plain")
                .baseUri("/")
                .build(uri, 1, size);
        links.add(first);

        Link last = Link.fromUri("{baseUri}?page={page}&size={size}")
                .rel("last")
                .type("text/plain")
                .baseUri("/")
                .build(uri, maxPage(size, total), size);
        links.add(last);

        return links;
    }

    protected int maxPage(int size, int total){
        return (int) (Math.ceil(total / size));
    }
}

# Endless Frontier API
[![Build Status](https://travis-ci.org/macgregor/endlessfrontier_api.svg?branch=master)](https://travis-ci.org/macgregor/endlessfrontier_api)

Unofficial Rest API for a mobile game (Endless Frontier - https://play.google.com/store/apps/details?id=com.ekkorr.endlessfrontier.global&amp;hl=en)

## Planning
### Unanswered Questions
* Programming Language - java 8 or 9? but might be a good chance to experiment with Go
* REST framework
* api documentation
* data storage - small data set that wont grow by much or very quickly. Theres a game update a few times a year that adds a handful of new pets/artifacts. Current dataset is 450k raw, would be surprised if it ever got close to 1M. So some kind of local storage, no need for standalone infrastructure. Research small local, queryable datastores. SQLite?
* deployment platform - aws, google, other. Looking for cheap (free). 
* CICD
* scalability - overkill, just need a single easy to deploy/maintain instance for now.
* containers - might be worthwhile to look in to/experiment with containerized deployments. Probably overkill for this project but it could make things easier in the future if i ever did need to add scaling
* authorization - OAuth? Free for all? Decision may be influenced by deployment platform, want to make sure someone cant hammer me into a huge bill. 

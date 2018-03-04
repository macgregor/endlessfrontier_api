package com.macgregor.ef.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "another_test")
public class AnotherTestEntity {
    @Id
    @Column(name="id", nullable = false)
    public Integer id;

    @Column(name = "name", nullable = false)
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnotherTestEntity that = (AnotherTestEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AnotherTestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

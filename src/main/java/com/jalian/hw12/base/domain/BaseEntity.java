package com.jalian.hw12.base.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@MappedSuperclass
public abstract class BaseEntity <ID> implements Serializable {
    //@Id
    protected ID id;

    public BaseEntity(ID id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    @Transient
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

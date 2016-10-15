package org.learn.bookpub.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Component;

@Component
@Entity
public class RoomEntity {

	@Id
    private long id;
//    private RoomCategory roomCategory;
    private String name;
    private String description;
 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    @XmlElement
//    public RoomCategory getRoomCategory() {
//        return roomCategory;
//    }
//
//    public void setRoomCategory(RoomCategory roomCategory) {
//        this.roomCategory = roomCategory;
//    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

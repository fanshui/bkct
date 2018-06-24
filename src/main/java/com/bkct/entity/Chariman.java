package com.bkct.entity;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Data
@Repository(value = "chariman")
public class Chariman {
    @Value("李白")
    private String name;
    @Value("54")
    private Integer age;
    @Value("119-211-425")
    private String phoneNumber;
    @Value("男")
    private String gender;
    @Value("明光楼45号")
    private String officer;
}

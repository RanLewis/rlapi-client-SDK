package com.ranlewis.rlapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Ran Lewis
 * @Version 1.0
 * @Description
 * @Date 2024/11/15 18:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String password;
}

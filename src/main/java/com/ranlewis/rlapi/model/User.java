package com.ranlewis.rlapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User model class.
 *
 * @author Ran Lewis
 * @version 1.0
 * @since 2024/11/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String password;
}

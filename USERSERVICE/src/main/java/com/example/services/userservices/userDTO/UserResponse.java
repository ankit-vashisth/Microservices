/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.userservices.userDTO;

import com.example.services.userservices.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ankit Vashistha
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UserEntity user;
    private String message;
}

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kevin
 * Created: 10-17-2021
 */
CREATE TABLE person(
    id bigserial primary key,
    name text not null,
    lastname text not null,
    email text not null,
    height int not null,
    birthday date not null,
    active boolean not null
);

package com.test.boot.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Images {
    private Long imageId;
    private byte[] data;
    private String title;

}

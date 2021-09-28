package com.rozbit.gifservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class GifDataDto implements Serializable {

    private String type;
    private String url;

    private String bitly_gif_url;
    private String bitly_url;
    private String embed_url;

    private String image_original_url;
    private String image_url;
    private String image_mp4_url;

    private String image_frames;
    private String image_width;
    private String image_height;

    private String fixed_height_downsampled_url;
    private String fixed_height_downsampled_width;
    private String fixed_height_downsampled_height;

    private String fixed_width_downsampled_url;
    private String fixed_width_downsampled_width;
    private String fixed_width_downsampled_height;

    private String fixed_height_small_url;
    private String fixed_height_small_still_url;
    private String fixed_height_small_width;
    private String fixed_height_small_height;

    private String fixed_width_small_url;
    private String fixed_width_small_still_url;
    private String fixed_width_small_width;
    private String fixed_width_small_height;

}

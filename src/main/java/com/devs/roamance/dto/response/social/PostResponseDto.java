package com.devs.roamance.dto.response.social;

import com.devs.roamance.dto.response.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto extends BaseResponseDto {

  private PostDto data;

  public PostResponseDto(int status, boolean success, String message, PostDto data) {

    super(status, success, message);
    this.data = data;
  }
}

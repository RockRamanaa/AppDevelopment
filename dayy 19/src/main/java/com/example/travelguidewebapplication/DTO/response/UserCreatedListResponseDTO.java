package com.example.travelguidewebapplication.DTO.response;

import com.example.travelguidewebapplication.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedListResponseDTO {
    String id;
    String destinationName;
    String imageUrl;
    String description;
    Integer estimatedCost;
    Status status;

    List<String> iconList;
}

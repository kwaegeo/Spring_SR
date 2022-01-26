package com.NoChu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Chart {

    int rank;

    String Artist;

    String SongName;

    String Album;

    String imgCover;

}

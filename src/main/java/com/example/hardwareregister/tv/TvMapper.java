package com.example.hardwareregister.tv;

import com.example.hardwareregister.tv.dto.TvDto;
import com.example.hardwareregister.tv.model.Tv;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TvMapper {
    public static TvDto toTvDto(Tv tv) {

        return TvDto.builder()
                .id(tv.getId())
                .name(tv.getName())
                .country(tv.getCountry())
                .manufacturer(tv.getManufacturer())
                .onlineOrder(tv.getOnlineOrder())
                .credit(tv.getCredit())
                .build();
    }

    public static Tv toTv(TvDto tvDto) {

        return Tv.builder()
                .id(tvDto.getId())
                .name(tvDto.getName())
                .country(tvDto.getCountry())
                .manufacturer(tvDto.getManufacturer())
                .onlineOrder(tvDto.getOnlineOrder())
                .credit(tvDto.getCredit())
                .build();
    }
}

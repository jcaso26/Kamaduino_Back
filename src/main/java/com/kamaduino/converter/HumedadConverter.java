package com.kamaduino.converter;

import com.kamaduino.dto.HumedadDTO;
import com.kamaduino.entity.Humedad;

public class HumedadConverter {

    public static HumedadDTO entityToDTO(Humedad humedad){
        HumedadDTO humedadDTO = new HumedadDTO(humedad.getId(), humedad.getHumedadSuperior(), humedad.getHumedadInferior(), humedad.getTime());
        return humedadDTO;
    }
//
//    public static Humedad dtoToEntity(HumedadDTO humedadDTO){
//        //TODO
//        Humedad humedad = new Humedad();
//
//        return humedad;
//    }
}

//
//    public static User dtoToEntity(UserDto userDto) {
//        User user = new User(userDto.getUserName(), null);
//        user.setUserId(userDto.getUserId());
//        user.setSkills(userDto.getSkillDtos().stream().map(SkillConverter::dtoToEntity).collect(Collectors.toList()));
//        return user;
//    }
//
//    public static UserDto entityToDto(User user) {
//        UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), null);
//        userDto.setSkillDtos(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
//        return userDto;
//    }
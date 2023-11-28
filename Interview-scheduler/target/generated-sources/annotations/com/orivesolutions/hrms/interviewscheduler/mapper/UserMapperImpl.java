package com.orivesolutions.hrms.interviewscheduler.mapper;

import com.orivesolutions.hrms.interviewscheduler.domain.User;
import com.orivesolutions.hrms.interviewscheduler.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-25T12:42:09+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setAddress( user.getAddress() );
        userDto.setEmailId( user.getEmailId() );
        userDto.setMobile( user.getMobile() );
        userDto.setRole( user.getRole() );
        userDto.setProfileUrl( user.getProfileUrl() );
        userDto.setForgetToken( user.getForgetToken() );
        userDto.setOtp( user.getOtp() );

        return userDto;
    }

    @Override
    public User toUser(UserDto user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setId( user.getId() );
        user1.setName( user.getName() );
        user1.setAddress( user.getAddress() );
        user1.setEmailId( user.getEmailId() );
        user1.setPassword( user.getPassword() );
        user1.setMobile( user.getMobile() );
        user1.setRole( user.getRole() );
        user1.setProfileUrl( user.getProfileUrl() );
        user1.setForgetToken( user.getForgetToken() );
        user1.setOtp( user.getOtp() );

        return user1;
    }

    @Override
    public List<User> toUsers(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( toUser( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toUserDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }
}

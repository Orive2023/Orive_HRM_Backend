package com.orivesolutions.hrms.interviewscheduler.mapper;

import com.orivesolutions.hrms.interviewscheduler.domain.Talent;
import com.orivesolutions.hrms.interviewscheduler.dto.TalentDto;
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
public class TalentMapperImpl implements TalentMapper {

    @Override
    public TalentDto toTalentDto(Talent talent) {
        if ( talent == null ) {
            return null;
        }

        TalentDto talentDto = new TalentDto();

        if ( talent.getId() != null ) {
            talentDto.setId( talent.getId() );
        }
        talentDto.setName( talent.getName() );
        talentDto.setRequirements( talent.getRequirements() );
        talentDto.setProjectName( talent.getProjectName() );
        talentDto.setManagerName( talent.getManagerName() );
        talentDto.setStartDate( talent.getStartDate() );
        talentDto.setEndDate( talent.getEndDate() );
        talentDto.setJobLocation( talent.getJobLocation() );

        return talentDto;
    }

    @Override
    public Talent toTalent(TalentDto talentDto) {
        if ( talentDto == null ) {
            return null;
        }

        Talent talent = new Talent();

        talent.setId( talentDto.getId() );
        talent.setName( talentDto.getName() );
        talent.setRequirements( talentDto.getRequirements() );
        talent.setProjectName( talentDto.getProjectName() );
        talent.setManagerName( talentDto.getManagerName() );
        talent.setStartDate( talentDto.getStartDate() );
        talent.setEndDate( talentDto.getEndDate() );
        talent.setJobLocation( talentDto.getJobLocation() );

        return talent;
    }

    @Override
    public List<Talent> toTalents(List<TalentDto> talentDtos) {
        if ( talentDtos == null ) {
            return null;
        }

        List<Talent> list = new ArrayList<Talent>( talentDtos.size() );
        for ( TalentDto talentDto : talentDtos ) {
            list.add( toTalent( talentDto ) );
        }

        return list;
    }

    @Override
    public List<TalentDto> toTalentDtos(List<Talent> talens) {
        if ( talens == null ) {
            return null;
        }

        List<TalentDto> list = new ArrayList<TalentDto>( talens.size() );
        for ( Talent talent : talens ) {
            list.add( toTalentDto( talent ) );
        }

        return list;
    }
}

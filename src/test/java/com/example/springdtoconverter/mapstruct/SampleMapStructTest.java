package com.example.springdtoconverter.mapstruct;

import com.example.springdtoconverter.common.sample.dto.SampleInsertDto;
import com.example.springdtoconverter.common.sample.dto.SampleSelectDto;
import com.example.springdtoconverter.common.sample.dto.SampleUpdateDto;
import com.example.springdtoconverter.common.sample.entity.SampleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleMapStructTest {

    @Autowired
    private SampleMapStruct mapper;

    @Test
    void testToDto() {
        // Given (Entity 생성)
        SampleEntity entity = new SampleEntity();
        entity.setId(1L);
        entity.setTitle("Test Title");
        entity.setContent("Test Content");
        entity.setUseYn(true);

        // When (Entity → DTO 변환)
        SampleSelectDto dto = mapper.toDto(entity);

        // Then (검증)
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(entity.getId());
        assertThat(dto.getTitle()).isEqualTo(entity.getTitle());
        assertThat(dto.getContent()).isEqualTo(entity.getContent());
        assertThat(dto.isUseYn()).isEqualTo(entity.isUseYn());
    }

    @Test
    void testToEntityFromInsertDto() {
        // Given (Insert DTO 생성)
        SampleInsertDto insertDto = new SampleInsertDto();
        insertDto.setTitle("New Title");
        insertDto.setContent("New Content");
        insertDto.setUseYn(false);

        // When (DTO → Entity 변환)
        SampleEntity entity = mapper.toEntity(insertDto);

        // Then (검증)
        assertThat(entity).isNotNull();
        assertThat(entity.getTitle()).isEqualTo(insertDto.getTitle());
        assertThat(entity.getContent()).isEqualTo(insertDto.getContent());
        assertThat(entity.isUseYn()).isEqualTo(insertDto.isUseYn());

        // ID는 매핑 대상이 아니므로 null 또는 0일 가능성 있음
        assertThat(entity.getId()).isNull();
    }

    @Test
    void testToEntityFromUpdateDto() {
        // Given (Update DTO 생성)
        SampleUpdateDto updateDto = new SampleUpdateDto();
        updateDto.setContent("Updated Content");
        updateDto.setUseYn(true);

        SampleEntity existingEntity = new SampleEntity();
        existingEntity.setId(1L);
        existingEntity.setTitle("Original Title");
        existingEntity.setContent("Original Content");
        existingEntity.setUseYn(false);

        // When (DTO → Entity 변환)
        SampleEntity updatedEntity = mapper.toEntity(updateDto);

        // Then (검증)
        assertThat(updatedEntity).isNotNull();
        assertThat(updatedEntity.getContent()).isEqualTo(updateDto.getContent());
        assertThat(updatedEntity.isUseYn()).isEqualTo(updateDto.isUseYn());

        // Update DTO에는 `title`이 없으므로, 변환 후에는 `title`이 null일 수 있음.
        assertThat(updatedEntity.getTitle()).isNull();
    }

    @Test
    void testToDtoList() {
        // Given (Entity 리스트 생성)
        SampleEntity entity1 = new SampleEntity();
        entity1.setId(1L);
        entity1.setTitle("Title 1");
        entity1.setContent("Content 1");
        entity1.setUseYn(true);

        SampleEntity entity2 = new SampleEntity();
        entity2.setId(2L);
        entity2.setTitle("Title 2");
        entity2.setContent("Content 2");
        entity2.setUseYn(false);

        List<SampleEntity> entityList = Arrays.asList(entity1, entity2);

        // When (Entity 리스트 → DTO 리스트 변환)
        List<SampleSelectDto> dtoList = mapper.toDto(entityList);

        // Then (검증)
        assertThat(dtoList).isNotNull().hasSize(2);
        assertThat(dtoList.get(0).getId()).isEqualTo(entity1.getId());
        assertThat(dtoList.get(1).getId()).isEqualTo(entity2.getId());
        assertThat(dtoList.get(0).getTitle()).isEqualTo(entity1.getTitle());
        assertThat(dtoList.get(1).getTitle()).isEqualTo(entity2.getTitle());
    }
}

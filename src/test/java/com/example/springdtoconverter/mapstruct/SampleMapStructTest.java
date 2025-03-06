package com.example.springdtoconverter.mapstruct;

import com.example.springdtoconverter.common.sample.dto.SampleInsertDto;
import com.example.springdtoconverter.common.sample.dto.SampleSelectDto;
import com.example.springdtoconverter.common.sample.dto.SampleUpdateDto;
import com.example.springdtoconverter.common.sample.entity.SampleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

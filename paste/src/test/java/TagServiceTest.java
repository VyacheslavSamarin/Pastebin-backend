import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kaistinea.paste.dto.TagDTO;
import org.kaistinea.paste.entity.TagEntity;
import org.kaistinea.paste.mapper.TagMapper;
import org.kaistinea.paste.repository.TagRepository;
import org.kaistinea.paste.service.TagService;
import org.kaistinea.paste.service.TagServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TagServiceTest {

    @Mock
    private TagRepository tagRepository;

    @Mock
    private TagMapper tagMapper;

    @InjectMocks
    private TagServiceImpl tagService;

    private TagDTO tagDTO;
    private TagEntity tagEntity;

    @BeforeEach
    void setUp() {
        tagDTO = new TagDTO();
        tagDTO.setName("test");

        tagEntity = new TagEntity();
        tagEntity.setId(1L);
        tagEntity.setName("test");
    }

    @Test
    void shouldDeleteTagWhenExists() {
        when(tagRepository.existsById(1L)).thenReturn(true);

        tagService.deleteTag(1L);

        verify(tagRepository).deleteById(1L);
    }

    @Test
    void shouldThrowNotFoundWhenDeletingNonExistentTag() {
        when(tagRepository.existsById(1L)).thenReturn(false);

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> tagService.deleteTag(1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    void shouldSaveTag() {
        when(tagMapper.toEntity(tagDTO)).thenReturn(tagEntity);
        when(tagRepository.save(tagEntity)).thenReturn(tagEntity);
        when(tagMapper.toDto(tagEntity)).thenReturn(tagDTO);

        TagDTO result = tagService.saveTag(tagDTO);

        assertNotNull(result);
        assertEquals(tagDTO.getName(), result.getName());
        verify(tagRepository).save(tagEntity);
    }


    @Test
    void shouldThrowNotFoundWhenGettingNonExistentTag() {
        when(tagRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> tagService.getTag(1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }




    @Test
    void shouldThrowNotFoundWhenUpdatingNonExistentTag() {
        when(tagRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> tagService.updateTag(tagDTO, 1L)
        );

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    void shouldGetAllTags() {
        when(tagRepository.findAll()).thenReturn(List.of(tagEntity));
        when(tagMapper.toDto(tagEntity)).thenReturn(tagDTO);

        List<TagDTO> tags = tagService.getTags();

        assertNotNull(tags);
        assertEquals(1, tags.size());
        assertEquals(tagDTO.getName(), tags.getFirst().getName());
    }

    @Test
    void shouldUpdateTagWhenExists() {
        when(tagRepository.findById(1L)).thenReturn(Optional.of(tagEntity));
        doNothing().when(tagMapper).updateTagEntity(tagEntity, tagDTO);
        when(tagMapper.toDto(tagEntity)).thenReturn(tagDTO);

        TagDTO result = tagService.updateTag(tagDTO, 1L);

        assertNotNull(result);
        assertEquals(tagDTO.getName(), result.getName());
        verify(tagMapper).updateTagEntity(tagEntity, tagDTO);
    }
}

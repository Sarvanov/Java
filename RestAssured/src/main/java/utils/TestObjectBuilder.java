package utils;

import dto.PetModel;

import java.util.List;

import static utils.TestDataHelper.*;

/**
 * ��������������� ����� ��� ������������ �������� ��������
 */
public class TestObjectBuilder {

    /**
     * ����� ��� ������������ ���� ������� �� �������� �������
     *
     * @param id ������������� �������
     * @return ���� �������
     */
    public static PetModel getAddNewPetModel(String id) {
        return PetModel.builder()
                .id(id)
                .category(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_CATEGORY_ID)
                        .name(getRandomCategoryName())
                        .build())
                .name(getRandomPetName())
                .photoUrls(List.of(getRandomUrl()))
                .tags(List.of(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_TAG_ID)
                        .name(VALID_TAG_NAME)
                        .build()))
                .status(VALID_STATUS)
                .build();
    }
}

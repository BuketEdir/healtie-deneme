package api.healtieDeneme.healtie.entities.dtos;

import lombok.Data;

@Data
public class LanguageImageDto {

    private int languageId;
    private String contentType;
    private String base64;


    @Override
    public String toString() {
        return "LanguageImageWrapper{" +
                "languageId=" + languageId +
                ", contentType='" + contentType + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}

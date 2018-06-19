package rodolfogusson.testemobilesaude.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDateTime;

public class News implements Serializable{

    private int id;

    @SerializedName("titulo")
    private String title;

    @SerializedName("conteudo")
    private String content;

    @SerializedName("sumario")
    private String summary;

    @SerializedName("data")
    private LocalDateTime date;

    @SerializedName("data_validade")
    private LocalDateTime expirationDate;

    @SerializedName("data_publicacao")
    private LocalDateTime publicationDate;

    @SerializedName("formato")
    private int format;

    @SerializedName("cod_operadora")
    private int operatorCode;

    @SerializedName("foto_principal_url")
    private String pictureURL;

    private String permalink;

    @SerializedName("post_tipo_id")
    private int postTypeId;

    @SerializedName("categorias")
    private int[] categories;

    @SerializedName("categorias_nomes")
    private String[] categoriesNames;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public int getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(int operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public int getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(int postTypeId) {
        this.postTypeId = postTypeId;
    }

    public int[] getCategories() {
        return categories;
    }

    public void setCategories(int[] categories) {
        this.categories = categories;
    }

    public String[] getCategoriesNames() {
        return categoriesNames;
    }

    public void setCategoriesNames(String[] categoriesNames) {
        this.categoriesNames = categoriesNames;
    }
}

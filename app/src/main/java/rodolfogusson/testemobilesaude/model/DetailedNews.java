package rodolfogusson.testemobilesaude.model;

import com.google.gson.annotations.SerializedName;

import org.joda.time.LocalDateTime;

/**
 * Class that represents a more detailed news object, shown at
 * {@link rodolfogusson.testemobilesaude.ui.activities.newsdetails.NewsDetailsActivity}.
 */
public class DetailedNews {

    private int id;

    @SerializedName("titulo")
    private String title;

    @SerializedName("conteudo")
    private String content;

    @SerializedName("data")
    private LocalDateTime date;

    @SerializedName("data_validade")
    private LocalDateTime expirationDate;

    @SerializedName("idioma")
    private String language;

    @SerializedName("cod_operadora")
    private Integer operatorCode;

    @SerializedName("foto_principal_url")
    private String pictureURL;

    @SerializedName("formato")
    private Integer format;

    private String permalink;

    private String status;

    @SerializedName("width_exibiçao")
    private Integer displayWidth;

    @SerializedName("height_exibiçao")
    private Integer displayHeight;

    @SerializedName("tipo_exibiçao")
    private Integer displayType;

    @SerializedName("exibir_titulo")
    private String showTitle;

    private String podcast;

    private String video;

    @SerializedName("autor")
    private String author;

    private String[] tags;

    @SerializedName("galeria_fotos")
    private String photos_gallery;

    @SerializedName("galeria_arquivos")
    private String files_gallery;

    @SerializedName("sanfona")
    private String[] accordion;

    @SerializedName("ambiente")
    private Integer ambient;

    @SerializedName("post_tipo_id")
    private Integer postTypeId;

    @SerializedName("categorias")
    private Integer[] categories;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(Integer operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(Integer displayWidth) {
        this.displayWidth = displayWidth;
    }

    public Integer getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(Integer displayHeight) {
        this.displayHeight = displayHeight;
    }

    public Integer getDisplayType() {
        return displayType;
    }

    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getPodcast() {
        return podcast;
    }

    public void setPodcast(String podcast) {
        this.podcast = podcast;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getPhotos_gallery() {
        return photos_gallery;
    }

    public void setPhotos_gallery(String photos_gallery) {
        this.photos_gallery = photos_gallery;
    }

    public String getFiles_gallery() {
        return files_gallery;
    }

    public void setFiles_gallery(String files_gallery) {
        this.files_gallery = files_gallery;
    }

    public String[] getAccordion() {
        return accordion;
    }

    public void setAccordion(String[] accordion) {
        this.accordion = accordion;
    }

    public Integer getAmbient() {
        return ambient;
    }

    public void setAmbient(Integer ambient) {
        this.ambient = ambient;
    }

    public Integer getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(Integer postTypeId) {
        this.postTypeId = postTypeId;
    }

    public Integer[] getCategories() {
        return categories;
    }

    public void setCategories(Integer[] categories) {
        this.categories = categories;
    }

    public String[] getCategoriesNames() {
        return categoriesNames;
    }

    public void setCategoriesNames(String[] categoriesNames) {
        this.categoriesNames = categoriesNames;
    }
}

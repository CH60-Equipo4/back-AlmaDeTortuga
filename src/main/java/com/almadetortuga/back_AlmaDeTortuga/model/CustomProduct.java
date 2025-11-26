package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "custom_product_details")
@PrimaryKeyJoinColumn(name = "id_product")
public class CustomProduct extends Product {

    @Column(name = "tote_type")
    private String toteSize;

    @Column(name = "url_imagen_subida")
    private String uploadedImageUrl;

    @Column(name = "texto_personalizado")
    private String customText;

    @Column(name = "tipo_fuente")
    private String fontType;

    @Column(name = "color_texto")
    private String textColor;

    @Column(name = "posicion_texto")
    private String textPosition;

    @Column(name = "image_position")
    private String imagePosition;

    public CustomProduct(Long idProduct, String name, String description, BigDecimal price, Integer stock, String urlProductImage,
                         Category category, String toteSize, String uploadedImageUrl, String customText, String fontType, String textColor,
                         String textPosition, String imagePosition) {
        super(idProduct, name, description, price, stock, urlProductImage, category);
        this.toteSize = toteSize;
        this.uploadedImageUrl = uploadedImageUrl;
        this.customText = customText;
        this.fontType = fontType;
        this.textColor = textColor;
        this.textPosition = textPosition;
        this.imagePosition = imagePosition;
    }

    public CustomProduct() {
        super();
        this.setCategory(Category.CUSTOM);
    }

    public String getToteSize() {
        return toteSize;
    }

    public void setToteSize(String toteSize) {
        this.toteSize = toteSize;
    }

    public String getUploadedImageUrl() {
        return uploadedImageUrl;
    }

    public void setUploadedImageUrl(String uploadedImageUrl) {
        this.uploadedImageUrl = uploadedImageUrl;
    }

    public String getCustomText() {
        return customText;
    }

    public void setCustomText(String customText) {
        this.customText = customText;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getTextPosition() {
        return textPosition;
    }

    public void setTextPosition(String textPosition) {
        this.textPosition = textPosition;
    }

    public String getImagePosition() {
        return imagePosition;
    }

    public void setImagePosition(String imagePosition) {
        this.imagePosition = imagePosition;
    }

    @Override
    public String toString() {
        return "CustomProduct{" +
                "toteSize='" + toteSize + '\'' +
                ", uploadedImageUrl='" + uploadedImageUrl + '\'' +
                ", customText='" + customText + '\'' +
                ", fontType='" + fontType + '\'' +
                ", textColor='" + textColor + '\'' +
                ", textPosition='" + textPosition + '\'' +
                ", imagePosition='" + imagePosition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CustomProduct that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(toteSize, that.toteSize) && Objects.equals(uploadedImageUrl, that.uploadedImageUrl) && Objects.equals(customText, that.customText) && Objects.equals(fontType, that.fontType) && Objects.equals(textColor, that.textColor) && Objects.equals(textPosition, that.textPosition) && Objects.equals(imagePosition, that.imagePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), toteSize, uploadedImageUrl, customText, fontType, textColor, textPosition, imagePosition);
    }
}

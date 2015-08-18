package com.ausya.rcore.account;

import com.stormpath.spring.security.provider.StormpathUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountBean implements Serializable {
    private final static Logger LOG = LoggerFactory.getLogger(AccountBean.class);
    public static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    public static final DateFormat dfDay = new SimpleDateFormat("dd");
    public static final DateFormat dfMonth = new SimpleDateFormat("MM");
    public static final DateFormat dfYear = new SimpleDateFormat("yyyy");
    public final static String USERNAME_KEY = "username";
    public final static String EMAIL_KEY = "email";
    public final static String CHANNEL_KEY = "channel";
    public final static String ABOUT_KEY = "about";
    public final static String BIRTH_DAY_KEY = "birthDay";
    public final static String GENDER_KEY = "gender";
    public final static String PHOTO_EXTENSION_KEY = "photoExtension";
    private String username;
    private String email;
    //custom fields
    private String channel;
    private String about;
    private String gender;
    private String day;
    private String month;
    private String year;
    private String photoExtension;
    public AccountBean() {}
    public AccountBean(StormpathUserDetails user, CustomDataBean customData) {
        try {
            username = user.getUsername();
            email = user.getProperties().get(EMAIL_KEY);

            for (CustomDataFieldBean customFiled : customData.getCustomDataFields()) {
                if (CHANNEL_KEY.equals(customFiled.getKey())) {
                    channel = (String) customFiled.getValue();
                } else if (ABOUT_KEY.equals(customFiled.getKey())) {
                    about = (String) customFiled.getValue();
                } else if (BIRTH_DAY_KEY.equals(customFiled.getKey())) {
                    try {
                        Date date = df.parse((String) customFiled.getValue());
                        day = dfDay.format(date);
                        month = dfMonth.format(date);
                        year = dfYear.format(date);
                    } catch (ParseException e) {
                        LOG.error(e.getMessage());
                    }
                } else if (GENDER_KEY.equals(customFiled.getKey())) {
                    gender = (String) customFiled.getValue();
                } else if (PHOTO_EXTENSION_KEY.equals(customFiled.getKey())) {
                    photoExtension = (String) customFiled.getValue();
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getPhotoExtension() {
        return photoExtension;
    }
    public void setPhotoExtension(String photoExtension) {
        this.photoExtension = photoExtension;
    }
    public String getBirthDay() {
        String dateStr = day + "-" + month + "-" + year;
        return dateStr;
    }

}

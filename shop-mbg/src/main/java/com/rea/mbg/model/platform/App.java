package com.rea.mbg.model.platform;

import java.io.Serializable;

public class App implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app.id
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app.name
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app.id
     *
     * @return the value of app.id
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app.id
     *
     * @param id the value for app.id
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app.name
     *
     * @return the value of app.name
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app.name
     *
     * @param name the value for app.name
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbg.generated Thu Dec 02 17:48:19 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
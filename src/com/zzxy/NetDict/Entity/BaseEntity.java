package com.zzxy.NetDict.Entity;

public class BaseEntity {
    
    private int id;//id,pk,ai,nn
    
    private String modified;//修改时间,NN
    
    private String modifier;//修改者，NN
    
    private String deleted;//删除时间
    
    private String deleter;//删除者
    
    private int delete_flag;//删除标志位，0：未删除，1：已删除，NN，df-0

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * @param modified the modified to set
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * @return the modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * @param modifier the modifier to set
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * @return the deleted
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    /**
     * @return the deleter
     */
    public String getDeleter() {
        return deleter;
    }

    /**
     * @param deleter the deleter to set
     */
    public void setDeleter(String deleter) {
        this.deleter = deleter;
    }

    /**
     * @return the delete_flag
     */
    public int getDelete_flag() {
        return delete_flag;
    }

    /**
     * @param delete_flag the delete_flag to set
     */
    public void setDelete_flag(int delete_flag) {
        this.delete_flag = delete_flag;
    }

}

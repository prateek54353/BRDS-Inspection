package bih.p003in.forestdept.entity;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class Block implements Serializable {
    public static Class<Block> BLOCK_CLASS = Block.class;
    private static final long serialVersionUID = 1;
    private String UserId;
    private String DistCode = "";
    private String BlockCode = "";
    private String BlockName = "";
    private String PacsBankId = "";

    public String getDistCode() {
        return this.DistCode;
    }

    public void setDistCode(String distCode) {
        this.DistCode = distCode;
    }

    public String getBlockCode() {
        return this.BlockCode;
    }

    public void setBlockCode(String blockCode) {
        this.BlockCode = blockCode;
    }

    public String getBlockName() {
        return this.BlockName;
    }

    public void setBlockName(String blockName) {
        this.BlockName = blockName;
    }

    public String getPacsBankId() {
        return this.PacsBankId;
    }

    public void setPacsBankId(String pacsBankId) {
        this.PacsBankId = pacsBankId;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }
}
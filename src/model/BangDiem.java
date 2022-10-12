/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author w7
 */
public class BangDiem {
    private int MaSo;
    private String maSV;
    private float TiengAnh;
    private float TinHoc;
    private float GDTC;
    public BangDiem(){}

    public BangDiem(int MaSo, String maSV, float TiengAnh, float TinHoc, float GDTC) {
        this.MaSo = MaSo;
        this.maSV = maSV;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
    }

    public int getMaSo() {
        return MaSo;
    }

    public void setMaSo(int MaSo) {
        this.MaSo = MaSo;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public float getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(float TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public float getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(float TinHoc) {
        this.TinHoc = TinHoc;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }
    
}

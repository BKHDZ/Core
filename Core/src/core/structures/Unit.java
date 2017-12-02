/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.structures;

/**
 *
 * @author FAMILIA
 */
public class Unit {

    Object data;

    public Unit() {
        data = null;
    }

    public Unit(String data) {
        this.data = data;
    }

    public Unit(Long data) {
        this.data = data;
    }

    public Unit(Double data) {
        this.data = data;
    }

    public Unit(Object data) {
        this.data = data;
    }

    public String getDataAsString() {
        if (this.data == null) {
            return "[null]";
        } else {
            if (this.data instanceof String) {
                return (String) this.data;
            }
            if (this.data instanceof Long) {
                return this.data.toString();
            }
            if (this.data instanceof Integer) {
                return this.data.toString();
            }
            if (this.data instanceof Double) {
                if (((Double) this.data) % 1 == 0) {
                    return ((Double) this.data).longValue() + "";
                } else {
                    return this.data.toString();
                }
            } else {
                return "[undefined]";
            }
        }
    }

    public Long getDataAsLong() {
        if (this.data == null) {
            return (long) 0;
        } else {
            if (this.data instanceof String) {
                try {
                    return Long.parseLong((String) this.data);
                } catch (Exception e) {
                    return (long) 0;
                }
            }
            if (this.data instanceof Integer) {
                return ((Integer) this.data).longValue();
            }
            if (this.data instanceof Long) {
                return (Long) this.data;
            }
            if (this.data instanceof Double) {
                return ((Double) this.data).longValue();
            } else {
                return (long) 0;
            }
        }
    }

    public Double getDataAsDouble() {
        if (this.data == null) {
            return (double) 0;
        } else {
            if (this.data instanceof String) {
                try {
                    return Double.parseDouble((String) this.data);
                } catch (Exception e) {
                    return (double) 0;
                }
            }
            if (this.data instanceof Long) {
                return ((Long) this.data).doubleValue();
            }
            if (this.data instanceof Integer) {
                return ((Integer) this.data).doubleValue();
            }
            if (this.data instanceof Double) {
                return (Double) this.data;
            } else {
                return (double) 0;
            }
        }
    }

}

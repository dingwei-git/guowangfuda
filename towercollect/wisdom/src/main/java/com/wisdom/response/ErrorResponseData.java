package com.wisdom.response;

public class ErrorResponseData extends ResponseData {
    private String exceptionClazz;

    public ErrorResponseData(String message) {
        super(false, ResponseData.DEFAULT_ERROR_CODE, message, (Object)null);
    }

    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, (Object)null);
    }

    public ErrorResponseData(Integer code, String message, Object object) {
        super(false, code, message, object);
    }

    public String getExceptionClazz() {
        return this.exceptionClazz;
    }

    public void setExceptionClazz(final String exceptionClazz) {
        this.exceptionClazz = exceptionClazz;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorResponseData)) {
            return false;
        } else {
            ErrorResponseData other = (ErrorResponseData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$exceptionClazz = this.getExceptionClazz();
                Object other$exceptionClazz = other.getExceptionClazz();
                if (this$exceptionClazz == null) {
                    if (other$exceptionClazz != null) {
                        return false;
                    }
                } else if (!this$exceptionClazz.equals(other$exceptionClazz)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponseData;
    }


    public String toString() {
        return "ErrorResponseData(exceptionClazz=" + this.getExceptionClazz() + ")";
    }
}

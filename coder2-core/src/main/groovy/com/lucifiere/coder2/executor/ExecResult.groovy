package com.lucifiere.coder2.executor

class ExecResult {

    private boolean success

    private String msg

    boolean getSuccess() {
        return success
    }

    void setSuccess(boolean success) {
        this.success = success
    }

    String getMsg() {
        return msg
    }

    void setMsg(String msg) {
        this.msg = msg
    }

    @Override
    String toString() {
        return "ExecResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}'
    }

}

package com.lucifiere.coder2.executor

class ExecResult<T> {

    private boolean success

    private String msg

    private T data

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

    T getData() {
        return data
    }

    void setData(T data) {
        this.data = data
    }

    static <T> ExecResult suc(T data) {
        ExecResult res = new ExecResult()
        res.setSuccess(true)
        res.setMsg("成功")
        res.setData(data)
        res
    }

    static ExecResult fail(String msg) {
        ExecResult res = new ExecResult()
        res.setSuccess(false)
        res.setMsg(msg)
        res
    }

    @Override
    String toString() {
        return "ExecResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}'
    }

}

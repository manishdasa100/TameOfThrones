package TameOfThrones.excahnges;

public class GetFileResponse{
    String response;
    String message;
    String fileContent;

    public void setResponse(String response) {
        this.response = response;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getResponse() {
        return this.response;
    }

    public String getFileContent() {
        return this.fileContent;
    }

    public String getMessage() {
        return this.message;
    }
}
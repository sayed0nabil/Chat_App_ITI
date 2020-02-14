package org.example.model;

import javafx.scene.layout.HBox;

public class MSGview extends HBox {
    private Message message ;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public MSGview(Message message) {
        this.message = message;
    }

    public void setTextMSGview(){

    }
    public void setVoiceMSGview(){

    }
    public void setImageMSGview(){

    }
    public void setFileMSGview(){

    }

}

package org.example.model;

import javafx.scene.layout.HBox;

public class MSGview extends HBox {
    private MSG message ;

    public MSG getMessage() {
        return message;
    }

    public void setMessage(MSG message) {
        this.message = message;
    }

    public MSGview(MSG message) {
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

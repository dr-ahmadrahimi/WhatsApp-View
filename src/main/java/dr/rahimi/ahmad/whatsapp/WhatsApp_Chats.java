package dr.rahimi.ahmad.whatsapp;

public class WhatsApp_Chats {
    String WhatsApp_time, WhatsApp_text;
    int WhatsApp_seen, WhatsApp_type;

    public WhatsApp_Chats(int type, String time, int seen, String text) {
        this.WhatsApp_time = time;
        this.WhatsApp_seen = seen;
        this.WhatsApp_type = type;
        this.WhatsApp_text = text;
    }


    public String getWhatsApp_time() {
        return WhatsApp_time;
    }

    public int getWhatsApp_seen() {
        return WhatsApp_seen;
    }

    public int getWhatsApp_type() {
        return WhatsApp_type;
    }

    public String getWhatsApp_text() {
        return WhatsApp_text;
    }

}

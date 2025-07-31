// Bridge Interface
interface DeliveryChannel {
    void sendMessage(String content);
}

// Concrete Implementations
class EmailDelivery implements DeliveryChannel {
    public void sendMessage(String content) {
        System.out.println("Sending via Email: " + content);
    }
}

class SMSDelivery implements DeliveryChannel {
    public void sendMessage(String content) {
        System.out.println("Sending via SMS: " + content);
    }
}

class WhatsAppDelivery implements DeliveryChannel {
    public void sendMessage(String content) {
        System.out.println("Sending via WhatsApp: " + content);
    }
}

// Abstraction
abstract class Message {
    protected DeliveryChannel deliveryChannel;

    public Message(DeliveryChannel deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }

    public abstract void send(String content);
}

// Refined Abstractions
class TextMessage extends Message {
    public TextMessage(DeliveryChannel deliveryChannel) {
        super(deliveryChannel);
    }

    public void send(String content) {
        deliveryChannel.sendMessage("Text: " + content);
    }
}

class ImageMessage extends Message {
    public ImageMessage(DeliveryChannel deliveryChannel) {
        super(deliveryChannel);
    }

    public void send(String content) {
        deliveryChannel.sendMessage("Image: " + content);
    }
}

class AudioMessage extends Message {
    public AudioMessage(DeliveryChannel deliveryChannel) {
        super(deliveryChannel);
    }

    public void send(String content) {
        deliveryChannel.sendMessage("Audio: " + content);
    }
}

// Client
public class MessagingSystem {
    public static void main(String[] args) {
        Message textViaEmail = new TextMessage(new EmailDelivery());
        Message imageViaWhatsApp = new ImageMessage(new WhatsAppDelivery());
        Message audioViaSMS = new AudioMessage(new SMSDelivery());

        textViaEmail.send("Hello from Bridge Pattern!");
        imageViaWhatsApp.send("funny_photo.jpg");
        audioViaSMS.send("voice_note.mp3");
    }
}

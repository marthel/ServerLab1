package BO;

import DB.DAL.ChatDb;
import DB.Entities.ChatMessageEntity;
import UI.ViewModels.ChatMessageViewModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ChatManager {

    private ChatDb db;

    public ChatManager(){
        this.db = new ChatDb();
    }

    public void sendMessage(ChatMessageViewModel chat) {
        db.addMessage(chat);
    }

    public List<ChatMessageViewModel> getChatMessagesBySenderAndReceiver(ChatMessageViewModel chat) {
        Collection<ChatMessageEntity> chatMessages = db.findChatMessagesBySenderAndReceiver(chat);
        return chatMessages.stream().map(Converter::convertToChatMessageViewModel).collect(Collectors.toList());
    }
}

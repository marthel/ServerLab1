package UI;

import BO.ChatManager;
import UI.ViewModels.ChatMessageViewModel;
import UI.ViewModels.UserViewModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class ChatBean {
    private ChatMessageViewModel chat;
    private ChatManager chatManager;

    @ManagedProperty(value="#{userBean.user}")
    private UserViewModel sender;
    public UserViewModel getSender() {
        return sender;
    }
    public void setSender(UserViewModel sender) {
        this.sender = sender;
    }
    public ChatBean() {
        this.chat = new ChatMessageViewModel();
        chatManager = new ChatManager();
    }
    public void setReceiver(UserViewModel receiver){
        this.chat.setReceiver(receiver);
    }
    public ChatMessageViewModel getChat() {
        return chat;
    }

    public void setChat(ChatMessageViewModel chat) {
        this.chat = chat;
    }

    public void sendMessage(){
        this.chat.setSender(this.sender);
        chatManager.sendMessage(chat);
        this.chat.setMessage("");
    }

    public List<ChatMessageViewModel> getChatMessages(){
        this.chat.setSender(this.sender);
        return chat.getReceiver() != null ? chatManager.getChatMessagesBySenderAndReceiver(chat) : null;
    }
}

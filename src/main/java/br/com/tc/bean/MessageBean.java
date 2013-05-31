package br.com.tc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.tc.model.TextModel;

@Named
@ApplicationScoped
public class MessageBean implements Serializable {
	private static final int MAX_SIZE = 25;
	
	private List<TextModel> textList = new ArrayList<TextModel>(0);

	public MessageBean() {
	}
	
	public List<TextModel> getTextList() {
		return textList;
	}

	public void setTextList(List<TextModel> textList) {
		this.textList = textList;
	}
	
	public void addToList(String sessionId, String color) {
		textList.add(makeTextModel(sessionId, color));
		
		if (textList.size() > MAX_SIZE) {
			textList.clear();
		}
	}
	
	private TextModel makeTextModel(String sessionId, String color) {
		return new TextModel("User with session ID of " + sessionId + " selected color \"" + color + "\".",
						     color);
	}
}

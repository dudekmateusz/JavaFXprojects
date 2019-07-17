package notepad;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

	
	@Entity
	@Table(name = "Notepad")
	
	public class Notepad {
		
		public Notepad(InputStream in) {
			
		}
		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@GeneratedValue(generator="increment") 
		@GenericGenerator(name="increment", strategy = "increment")
		
		private int id;
		
		@Column(name = "title")
		private String title;
		
		@Column(name = "data")
		private static Date data;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getData() {
			return data.toString();
		}
		public void setData(Date date) {
			Notepad.data = Calendar.getInstance().getTime();
		
		}
		public  void setId(int id) {
			this.id = id;
			
		}
		@Override
		public String toString() {
			return id + "|" + title + "|" + data;
		}

	}

package AnywrTest.security.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="User")
public class User {
	@Id
	@GeneratedValue
	private Long userId ;
	@Column(unique=true)
	private String username;
	private String password;
	private String role;


}

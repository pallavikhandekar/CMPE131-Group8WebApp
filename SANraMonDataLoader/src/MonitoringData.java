
/***
 * Defines Monitor Data Object
 * @author Pallavi
 *
 */
public class MonitoringData {

	 String io_type;
	 String io_channel;
	 String lun;
	 String timestamp;
	 String IP_address;
	 String number_of_data_blocks;
	 String duration;
	 String iops;

	 
	 public String getIo_type() {
		return io_type;
	}
	public void setIo_type(String io_type) {
		this.io_type = io_type;
	}
	public String getIo_channel() {
		return io_channel;
	}
	public void setIo_channel(String io_channel) {
		this.io_channel = io_channel;
	}
	public String getLun() {
		return lun;
	}
	public void setLun(String lun) {
		this.lun = lun;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getIP_address() {
		return IP_address;
	}
	public void setIP_address(String iP_address) {
		IP_address = iP_address;
	}
	public String getNumber_of_data_blocks() {
		return number_of_data_blocks;
	}
	public void setNumber_of_data_blocks(String number_of_data_blocks) {
		this.number_of_data_blocks = number_of_data_blocks;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getIops() {
		return iops;
	}
	public void setIops(String iops) {
		this.iops = iops;
	}
	
	
	
}

package org.learn.bookpub.service;

import org.learn.bookpub.entity.RoomEntity;
import org.learn.bookpub.model.RoomModel;
import org.learn.bookpub.repository.JpaRoomRepository;
import org.learn.bookpub.utils.CopyBeanValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomService {

//	public static List<Room> rooms = new ArrayList<>();
//	JpaRoomRepository jpaRoomRepository = new JpaRoomRepository();
	@Autowired
	public JpaRoomRepository jpaRoomRepository;	
	
	public JpaRoomRepository getJpaRoomRepository() {
		return jpaRoomRepository;
	}

	public void setJpaRoomRepository(JpaRoomRepository jpaRoomRepository) {
		this.jpaRoomRepository = jpaRoomRepository;
	}
	
	@Autowired
	RoomEntity roomEntity;
//	RoomEntity roomEntity = new RoomEntity();
	RoomModel roomModel = new RoomModel();
//	
	public RoomModel createRoom(RoomModel roomModel){
		System.out.println("roomModel :" + roomModel);
		roomEntity = jpaRoomRepository.save(CopyBeanValues.copyBeanValues(roomModel,roomEntity ));
		return CopyBeanValues.copyBeanValues(roomEntity , roomModel );
	}
//
//	private void printRooms() {
//		rooms.stream()
//			.map(a -> a.getName())
//			.forEach(System.out::println);
//	}
	
	public RoomModel getRoom(int id) {
		System.out.println("Service getRoom called");
//		try{
		roomEntity = jpaRoomRepository.findById(id);
		return CopyBeanValues.copyBeanValues(roomEntity , roomModel );
			
//		} catch(Exception e){
//			throw new RoomUnAvailableException("Room "+id+ " not available");
//		}
	}

	public RoomModel getRoomByName(String roomName) {
		System.out.println("Service getRoomByName called");
		roomEntity = jpaRoomRepository.findByName(roomName);
		return CopyBeanValues.copyBeanValues(roomEntity , roomModel );
	}

//	public static Room updateRoom(Room room, int id) {
//		Room roomOld = getRoom(id);
//		rooms.remove(roomOld);
//		rooms.add(room);
//		printRooms();
//		return room;
//	}
//
//	public static void deleteRoom(int id) {
//		Room room = getRoom(id);
//		rooms.remove(room);
//		printRooms();
//		
//	}
	
}

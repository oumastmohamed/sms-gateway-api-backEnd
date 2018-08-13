package master.enset.pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import master.enset.pfe.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer>{

}

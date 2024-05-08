package Repository;

import Entities.PublishingHouse;
import java.util.List;

public class PublishingHouseRepository extends AbstractRepository<PublishingHouse>{

        public PublishingHouseRepository() {
            super(PublishingHouse.class);
        }

        @Override
        public void create(PublishingHouse publishingHouse) {
            super.create(publishingHouse);
        }

        @Override
        public PublishingHouse findById(Integer id) {
            return super.findById(id);
        }

        @Override
        public List<PublishingHouse> findByName(String name) {
            return super.findByName(name);
        }

}

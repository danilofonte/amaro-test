CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `baseproduct` bigint(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
  --
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK4cm1kg523jlopyexjbmi6y54j` FOREIGN KEY (`baseproduct`) REFERENCES `product` (`id`);
  

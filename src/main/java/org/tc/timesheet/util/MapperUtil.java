package org.tc.timesheet.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class MapperUtil {

	public static <T, U> U map(T from, Class<U> toClass) {
		if (from != null) {
			try {
				U to = toClass.newInstance();
				BeanUtils.copyProperties(from,to);
				return to;
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			return null;
		}
	}

	public static <T, U> List<U> map(List<T> fromList, Class<U> toListClass) {
		List<U> toList = new ArrayList<U>();

		if (fromList != null && fromList.size() > 0) {
			Iterator<T> listIter = fromList.iterator();

			while (listIter.hasNext()) {
				toList.add(MapperUtil.map(listIter.next(), toListClass));
			}
		}

		return toList;
	}
}

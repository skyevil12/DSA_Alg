/*
 *  multi key data sort
 *  sort by surname then sort by given name alphabetically
 *  1. sort secnd condtion stable first
 *  2. sort first condition
 */

import java.util.LinkedList;
import java.util.Queue;

public class GFG {

	 private static class Employee {
        public String extenstion;
        public String givenname;
        public String surname;

        public Employee(String surnam, String givenname) {
            this.surname = surnam;
            this.givenname = givenname;
        }
    }

	public static void main(String[] args) {

		Employee[] data = createEmployeeData();
        data = mergaSortEmployee(data);

        for (Employee employee : data) {
            System.out.println(employee.surname + " " + employee.givenname);
        }
	}
	
	private static Employee[] createEmployeeData() {
        Employee[] data = new Employee[10];
        data[0] = new Employee("ddd", "aaa");
        data[1] = new Employee("bbb", "ddd");
        data[2] = new Employee("ccc", "ccc");
        data[3] = new Employee("eee", "fff");
        data[4] = new Employee("aaa", "bbb");
        data[5] = new Employee("bbb", "ccc");
        data[6] = new Employee("ccc", "bbb");
        data[7] = new Employee("ggg", "bbb");
        data[8] = new Employee("ddd", "bbb");
        data[9] = new Employee("fff", "ggg");
        return data;
    }

	private static Employee[] mergaSortEmployee(Employee[] data) {
		if (data.length < 2) {
			return data;
		}

		int middle = data.length / 2;
		Employee[] leftData = new Employee[middle];
		System.arraycopy(data, 0, leftData, 0, leftData.length);

		Employee[] rightData = new Employee[data.length - middle];
		System.arraycopy(data, middle + 1, rightData, 0, rightData.length);

		mergaSortEmployee(leftData);
		mergaSortEmployee(rightData);

		return merge(data, leftData, rightData);
	}

	private Employee[] merge(Employee[] data, Employee[] leftData, Employee[] rightData) {
		int dataIndex = 0;
		int lefIndex = 0;
		int rightIndex = 0;
		while (lefIndex < leftData.length && rightIndex < rightData.length) {
			if (leftData[lefIndex].surname.compareToIgnoreCase(rightData[rightIndex].surname) < 0) {
				data[dataIndex++] = leftData[lefIndex++];

			} else if (leftData[lefIndex].surname.compareToIgnoreCase(rightData[rightIndex].surname) > 0) {
				data[dataIndex++] = rightData[rightIndex++];

			} else {
				if (leftData[lefIndex].givenname.compareToIgnoreCase(rightData[rightIndex].givenname) <= 0) {
					data[dataIndex++] = leftData[lefIndex++];

				} else {
					data[dataIndex++] = rightData[rightIndex++];
				}
			}
		}

		while (lefIndex < leftData.length) {
			data[dataIndex++] = leftData[lefIndex++];
		}

		while (rightIndex < rightData.length) {
			data[dataIndex++] = rightData[rightIndex++];
		}

		return data;
	}


}
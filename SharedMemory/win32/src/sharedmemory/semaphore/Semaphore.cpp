/*
 * Semaphore.cpp
 *
 *  Created on: 08/gen/2010
 *      Author: Giuseppe Miscione
 */

#include <sharedmemory/semaphore/Semaphore.h>

namespace sharedmemory {
namespace semaphore {

	Semaphore::Semaphore(string semaphoreName, LONG initialCount, LONG maxCount) :
		semaphoreName(semaphoreName)
	{
		semaphoreHandle = NULL;

		this->initialCount = initialCount;
		this->maxCount = maxCount;

		semaphoreHandle = CreateSemaphore(NULL, this->initialCount, this->maxCount, this->semaphoreName.c_str());
		if(semaphoreHandle == NULL) {
			throw CreateSemaphoreException(Util::getLastErrorMessage());
		}
	}

	Semaphore::~Semaphore() {
		if(semaphoreHandle != NULL) {
			if(CloseHandle(semaphoreHandle)) {
				semaphoreHandle = NULL;
			}
		}
	}

	string Semaphore::getSemaphoreName() const {
		return semaphoreName;
	}

	HANDLE Semaphore::getSemaphoreHandle() const {
		return semaphoreHandle;
	}

	LONG Semaphore::getInitialCount() const {
		return initialCount;
	}

	LONG Semaphore::getMaxCount() const {
		return maxCount;
	}

	SemaphoreState Semaphore::wait() {
		return wait(INFINITE);
	}

	SemaphoreState Semaphore::wait(DWORD milliseconds) {
		if(semaphoreHandle == NULL) {
			throw NullPointerException();
		}
		SemaphoreState ret(WaitForSingleObject(semaphoreHandle, milliseconds));
		if(ret.isErrorState()) {
			throw WaitSemaphoreException(Util::getLastErrorMessage());
		}
		return ret;
	}

	LONG Semaphore::signal() {
		return signal(1);
	}

	LONG Semaphore::signal(LONG count) {
		if(semaphoreHandle == NULL) {
			throw NullPointerException();
		}
		LONG old = 0;
		if(!ReleaseSemaphore(semaphoreHandle, count, &old)) {
			throw SignalSemaphoreException(Util::getLastErrorMessage());
		}
		return old;
	}

}
}

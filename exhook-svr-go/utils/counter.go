package exhook

import (
    "sync"
    "time"
    "math"
)

type Counter struct {
    count int64
    start int64
    duration int64
    maxCount int64
    lock sync.Mutex
}

func NewCounter(duration int64, maxCount int64) *Counter {
	counter := &Counter{}
	counter.count = 0
	counter.start = time.Now().UnixNano() / 1e6   // 当前毫秒时间戳
	if (duration == 0) {
		counter.duration = math.MaxInt64  // duration传0表示没有时间间隔限制，计数器不刷新
	} else {
		counter.duration = duration
	}
	counter.maxCount = maxCount
	return counter
}

// Count 计数器计数
// n: 计数值
// refersh: 计数器是否刷新
// limit: 是否达到计数最大值
// num: 计数后计数器的值
func (counter *Counter) Count(n int64) (refresh bool, limit bool, num int64) {
	now := time.Now().UnixNano() / 1e6
	counter.lock.Lock()
	defer counter.lock.Unlock()

	if now - counter.start < counter.duration {
		counter.count += n
		num = counter.count
		limit = num > counter.maxCount
	} else {
		// num = counter.count  // 刷新前的最大计数
		counter.start = now
		counter.count = 0
		refresh = true
	}
	return
}

func (counter *Counter) GetCount() (num int64) {
    counter.lock.Lock()
    defer counter.lock.Unlock()
	return counter.count
}
